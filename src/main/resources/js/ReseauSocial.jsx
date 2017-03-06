class Forum extends React.Component {
  render() {

    var f = this.props.frm;

    var deleteArticle = event => {this.props.onDel(f.,
      ar.quantity,ar.observation);}
      return (<tr>
        <td>{this.props.frt.description}</td>
        <td></td>
        <td>{this.props.frt.quantity}</td>
        <td></td>
        <td>{this.props.frt.observation}</td>

        <span onClick={deleteArticle}>
          <input type="submit" value="Supp" class="btn btn-danger" style={{position: "absolute", left: "500px", color:"white", background:"black"}}/>
        </span>

</tr>
      )
    }
}
class Main extends React.Component {
    
   
    render(){
        return(
                <div>
                <h1> hello Forum </h1>
                </div>
                )
    }
}



ReactDOM.render(
	<Main title="welcome to your forum" />,
	document.getElementById('idRS')
)
