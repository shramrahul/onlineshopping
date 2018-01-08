
$(function(){

    var $table = $("#productListTable");
    if($table.length) {

        $("#id_"+menu).click(function (e) {


            console.log("categoryId=" + window.categoryId);
            var jsonUrl = '';
            if (window.categoryId === '' || window.categoryId === undefined) {
                jsonUrl = window.contextRoot + '/json/data/all/products';
            } else {
                jsonUrl = window.contextRoot + '/json/data/category/' + window.categoryId + '/products';
            }

            console.log("url=" + jsonUrl);

            console.log("here");
            $.ajax({
                url: jsonUrl,
                method: "GET",
                success: function (data) {

                    console.log(data);
                }
            });
        });
        // var tr =$('<tr>');
        // $.each(products,function (i,prod) {
        //
        //     $('<td>').html(prod[0]).appendTo(tr);
        //     $('<td>').html(prod[1]).appendTo(tr).append('<br/>');
        //
        // });
        // $table.append(tr);

        $table.DataTable({
            lengthMenu:[[3,5,10,-1],["3 Records","5 Records","10 Records","All Records"]],
            pageLength:5,
            ajax:{
                url:"/json/data/all/products",
                dataSrc:''
            },
            columns:[
                {
                    data:'name',
                },
                {
                    data:'brand',
                },
                {
                    data:'unitPrice',
                },
                {
                    data:'quantity',
                },
            ]
        })

    }

});

