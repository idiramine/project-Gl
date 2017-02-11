
class Article extends React.Component {
  render() {

    var ar = this.props.art;

    var deleteArticle = event => {this.props.onDel(ar);}
      return (<tr>
        <td>{this.props.art.description}</td>
        <td></td>
        <td>{this.props.art.quantity}</td>
        <td></td>
        <td>{this.props.art.observation}</td>

        <span onClick={deleteArticle}>
          <input type="submit" value="Supp" style={{position: "absolute", left: "500px", color:"white", background:"black"}}/>
        </span>

</tr>
      )
    }
}
class ArticleNew extends React.Component {
  render() {

    var addArticle = event => {
    event.preventDefault();
    this.props.onAdd(
    this.refs.DescriptionInput.value,
    parseFloat(this.refs.QuantityInput.value),
    this.refs.ObservationInput.value
    );
    this.refs.DescriptionInput.value = "";
    this.refs.QuantityInput.value = "";
    this.refs.ObservationInput.value = "";
    }
    return (<form>
    <input type="text" placeholder="Description" ref="DescriptionInput"/><br/>
    <input type="text" placeholder="Quantity" ref="QuantityInput"/><br/>
    <input type="text" placeholder="Observation" ref="ObservationInput"/><br/>
    <input type="submit" value="Add" onClick={addArticle}/>
    </form>)

    }


}

class ArticleApp extends React.Component {

  componentDidMount(){

  this.loadData()
  }

  constructor(props) {
    super(props);
    this.state = {Articles: [
        {description: 'idiramine', observation: 'admin', quantity: 'mdpidiramine'},
        {description: 'idiramine2', observation: 'user', quantity: 'mdpidiramine2' },
        ]};
  }

  loadData(){
    superagent
    .get('/api/articleses') // not HATEOS :(
    .end( (err, response) => {
    if (err == null) {
    this.setState({Articles: response.body._embedded.articleses})
  }
    });
  }

  addArticle(description, quantity, observation ) {

      var newart = {description, quantity, observation};
      superagent
      .get('/api/articleses') // not HATEOS :(
      .end( (err, response) => {
      if (err == null) {
      var Artcls= response.body._embedded.articleses.filter(i => i!=newart);
    }
      });
  superagent
  .post('/api/articleses') // not HATEOS :(
  .set('Content-Type', 'application/json')
  .send(newart)
  .end( function(err, response) {
  if (err == null) {
  this.setState({
  Articles: [...this.state.Articles, newart]
  });
  }
  }.bind(this));
  }




  deleteArticleser(ar) {
  superagent
  .delete(ar._links.self.href) // not HATEOS :(
  .end( function(err, response) {
  if (err == null) {
    this.setState({
  Articles: [...this.state.Articles.filter(i => i!=ar)]
  });

  }
  }.bind(this));
  ar.quantity=0;
  superagent
  .post('/api/articleses') // not HATEOS :(
  .set('Content-Type', 'application/json')
  .send(ar)
  .end( function(err, response) {
  if (err == null) {
  this.setState({
  Articles: [...this.state.Articles, ar ]
  });
  }
  }.bind(this));
  }


  render() {

var lesitems = (this.state.Articles.filter(i => i.quantity!=0).map(listArticles=> <Article
  art={ listArticles}
   onDel={ this.deleteArticleser.bind(this) }/>));


      return (<div>
        <h1 style={{background:"red", color:"blue"}}> {this.props.titre} </h1>
        <h2> there is {this.state.Articles.length} Articles  </h2>
          <h3 style={{color:"blue"}}> Adding Articles
             <ArticleNew onAdd={ this.addArticle.bind(this) } />
          </h3>

        <table>
           <tr>
              <th>Description</th>
              <th>--------------------</th>
              <th>Quantity</th>
              <th>--------------------</th>
              <th>Observation</th>
              <th></th>
           </tr>
           {lesitems}
        </table>



</div>
      )

    }
}


ReactDOM.render(
  <ArticleApp titre="Articles"/>,
  document.getElementById('iddiv')
);
