$('.compra').on("click", function(){
    myCarrito= localStorage.getItem("myCarrito");

    $.ajax({
        type:"post",
        data:{"myCarrito": myCarrito},
        url:"CInsertForm",
        datatype: "json",
        success: function(result){
        },error: function(xhr){
            alert ("Ha ocurrido un error"+xhr.status+ " "+xhr.estatusText);
        }
    })
})