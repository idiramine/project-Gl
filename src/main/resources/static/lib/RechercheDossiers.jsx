

class Dossier extends React.Component {
  render() {

    var f = this.props.file;
var str=this.props.file._links.self.href;
var c=str.charAt(str.length-1);
var sr="/seefiles/"+c;
      return (<tr>
        <td>{this.props.file.fileName}</td>
        <td><a href={sr}>(VOIR)</a></td>
        <td>"{this.props.file.observation}"</td>

        <span>
          <input type="submit" value="Supp" className="btn btn-danger" />
        </span>

</tr>
      )
    }
}
class update extends React.Component {
  render(){
alert(sdfghjk);
}
}

class DossiersApp extends React.Component {

  componentDidMount(){

  this.loadData()
  }

  constructor(props) {
    super(props);
    this.state = {Files: []};
  }

  loadData(){
    superagent
    .get('/api/fileses') // not HATEOS :(
    .end( (err, response) => {
    if (err == null) {
    this.setState({Files: response.body._embedded.fileses})
  }
    });
  }

  update() {
  alert("sdfghjk");

  }
  render() {

var lesitems = (this.state.Files.map(listArticles=> <Dossier
  file={ listArticles}/>));


      return (<div>

        <input type="search" aria-controls="id1"/>

          <div className="panel panel-default">
              <div className="panel-heading">Articles</div>
        <table id="id1" className="table table-hover">
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
  <DossiersApp titre="Dossiers"/>,
  document.getElementById('iddiv')
);
