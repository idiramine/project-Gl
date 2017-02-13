
class Article extends React.Component {
  render() {

    var ar = this.props.art;

    var deleteArticle = event => {this.props.onDel(ar.description,
      ar.quantity,ar.observation);}
      return (<tr>
        <td>{this.props.art.description}</td>
        <td></td>
        <td>{this.props.art.quantity}</td>
        <td></td>
        <td>{this.props.art.observation}</td>

        <span onClick={deleteArticle}>
          <input type="submit" value="Supp" class="btn btn-danger" style={{position: "absolute", left: "500px", color:"white", background:"black"}}/>
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
      var ar;
      superagent
      .get('/api/articleses') // not HATEOS :(
      .end( (err, response) => {
      if (err == null) {
      var Artcls= response.body._embedded.articleses.filter(
        i => i.description ==
        newart.description);
        ar=Artcls[0];
        if(ar!=undefined){
        newart.quantity=newart.quantity+ar.quantity;
        superagent
        .put(ar._links.self.href)
        .send(newart)
        .end ( function(err, response) {
          superagent
          .get('/api/articleses') // not HATEOS :(
          .end( (err, response) => {
          if (err == null) {
            superagent
    .get('/api/articleses') // not HATEOS :(
    .end( (err, response) => {
    if (err == null) {
    this.setState({Articles: response.body._embedded.articleses})
  }
    }.bind(this));
          }
          }.bind(this));


      }.bind(this));
    }else {

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

}
}.bind(this));
  }




  deleteArticleser(description, quantity, observation) {
    var a={description,quantity,observation};
    superagent
    .get('/api/articleses') // not HATEOS :(
    .end( (err, response) => {
    if (err == null) {
    var Artcls= response.body._embedded.articleses.filter(
      i => i.description ==
      a.description);
      a=Artcls[0];
      var f={description,quantity,observation};
      f.quantity=0;
      superagent
      .put(a._links.self.href)
      .send(f)
      .end ( function(err, response) {
        superagent
        .get('/api/articleses') // not HATEOS :(
        .end( (err, response) => {
        if (err == null) {
          superagent
    .get('/api/articleses') // not HATEOS :(
    .end( (err, response) => {
    if (err == null) {
    this.setState({Articles: response.body._embedded.articleses})
    }
    }.bind(this));
        }
        }.bind(this));
    }.bind(this));
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
