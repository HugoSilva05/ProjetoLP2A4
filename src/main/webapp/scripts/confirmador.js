function confirmar(idProd){
	let response = confirm("Deseja excluir esse produto?")
	if(response === true){
		window.location.href=`delete?idProd=${idProd}`
	}
}