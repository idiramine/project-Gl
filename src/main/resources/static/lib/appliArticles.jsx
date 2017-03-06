

class Article extends React.Component {
  render() {

    var ar = this.props.art;

    var deleteArticle = event => {this.props.onDel(ar.description,
      ar.quantity,ar.observation);}
      return (<tr>
        <td>{this.props.art.description}</td>
        <td>{this.props.art.quantity}</td>
        <td>{this.props.art.observation}</td>

        <span onClick={deleteArticle}>
          <input type="submit" value="Supp" className="btn btn-danger" />
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
      <div className="panel panel-primary">
<div className="panel-heading">
  <h3 className="panel-title"> Ajouter Un Article</h3>
</div>
<div className="panel-body">
  <div className="form-group" >
      <div className="panel panel-default">
          <div className="panel-heading">Informations Sur L'Article</div></div>
          <div>Description
    <input className="form-control" type="text"  ref="DescriptionInput"/></div>
    <div>Quantity
    <input className="form-control" type="number" min="0" ref="QuantityInput"/></div>
    <div>Observation
    <input className="form-control" type="text"  ref="ObservationInput"/></div>
    <input type="submit" value="Add" className="btn btn-success" onClick={addArticle}/>
    </div>
</div>

</div>
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
        <nav className="navbar navbar-inverse">
        <div className="container-fluid">
        <div className="navbar-header">

        <a className="navbar-brand" href="#">AAPA</a>
        </div>
        <div className="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
        <ul className="nav navbar-nav">
         <li><a href="/GPA/">Accueil<span className="sr-only">(current)</span></a></li>
          <li><a href="/GPA/ListPub">Gestion Page d'Accueil</a></li>
            <li className="active"><a href="/gestionfiles">Gestion Interne</a></li>
              <li><a href="/GPA">Gestion Reseau Social</a></li>

        </ul>
        </div>
        </div>
        </nav>
        <ul className="nav nav-tabs">
        <li role="presentation"><a href="/gestionfiles">Gestion Des Dossiers</a></li>
        <li role="presentation"><a href="/Seedonations">Gestion Des Dons</a></li>
        <li role="presentation" className="active"><a href="gestionstock">Gestion Du Stock</a></li>
        <li role="presentation"><a href="/gestioncomptes">Gestion Des Comptes</a></li>

        </ul>


             <ArticleNew onAdd={ this.addArticle.bind(this) } />


          <div className="panel panel-default">
              <div className="panel-heading">Articles</div>
        <table className="table table-hover">
           <tr>
              <th>Description</th>
              <th>Quantity</th>
              <th>Observation</th>
              <th></th>
           </tr>
           {lesitems}
        </table>
            </div>


</div>
      )

    }
}


ReactDOM.render(
  <ArticleApp titre="Articles"/>,
  document.getElementById('iddiv')
);
