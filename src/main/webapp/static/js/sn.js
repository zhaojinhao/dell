$(function(){
    //字符串截取
    $(".styled-select select").bind("change",function(){
        if($(this).val().length>15){
            var text=$(this).val().substring(0,15)+"...";
            $(this).append('<option selected="selected" style="display: none" value='+$(this).val()+'>'+text+'</option>');
        }
    })
    //提交按钮
        /*$("#sn-show").click(function(){
            $(".num").css("display","none");
            $(".sn").css("display","block");
        })*/
    //选择配件直接提交成功后跳转主页
    //$(".parts").bind("change",function(){
    //    var data={
    //        "data1":$("#data1").val(),
    //        "data2":$("#data2").val(),
    //        "data3":$("#data3").val(),
    //        "data4":$("#data4").val(),
    //    },
    //    //$.ajax({
    //    //    url : ,
    //    //    type : "POST",
    //    //    dataType: "json",
    //    //    data:data
    //    //    success : function(data) {
    //    //        alert("提交成功",function(){
    //    //            window.location.href = "";
    //    //        });
    //    //        }
    //    //    }
    //    //});
    //})
    //输入SN编码提交,成功跳转页面
    //$("#sub").click(function(){
    //    $.ajax({
    //        url : ',
    //        type : "POST",
    //        dataType: "json",
    //        data:{
    //            "data1":$("#data1").val(),
    //            "data2":$("#data2").val(),
    //            "data3":$("#data3").val(),
    //            "data5":$("#data5").val(),
    //        }
    //        success : function(data) {
    //            alert("提交成功",function(){
    //                window.location.href = "";
    //            });
    //        }
    //    }
    //});
    //})
})