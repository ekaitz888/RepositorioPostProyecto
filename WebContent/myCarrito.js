$('.compra').on("click", function(){
    myCarrito= localStorage.getItem("myCarrito");

    $.ajax({
        type:"post",
        data:{"myCarrito": myCarrito},
        url:"http://localhost:8080/proyecto_final/CInsertForm",
        datatype: "json",
        success: function(result){
            alert("Correcto");
        },error: function(xhr){
            alert ("Ha ocurrido un error"+xhr.status+ " "+xhr.estatusText);
        }
    })
})