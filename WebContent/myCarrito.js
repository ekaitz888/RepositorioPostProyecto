$('.compra').on("click", function(){
    myCarrito= localStorage.getItem("myCarrito");

    $.ajax({
        type:"POST",
        data:{"myCarrito": myCarrito},
        url:"http://10.22.72.108:8080/proyecto_final/CInsertFactura",
        datatype: "json",
        success: function(response){
            alert(response);
            console.log(response);
        },error: function(xhr){
            alert ("Ha ocurrido un error"+xhr.status+ " "+xhr.estatusText);
        }
    })
})