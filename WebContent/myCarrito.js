$('.compra').on("click", function(){
    myCarrito= localStorage.getItem("myCarrito");

    $.ajax({
        type:"POST",
        data:{"myCarrito": myCarrito},
        url:"http://10.22.72.108:8080/proyecto_final/CInsertForm",
        datatype: "json",
        success: function(response){
            alert(response);
        },error: function(xhr){
            alert ("Ha ocurrido un error"+xhr.status+ " "+xhr.estatusText);
        }
    })
})