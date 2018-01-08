<div class="container">
    <div class="row">
        <div class="col-md-3">
            <%@include file="./shared/sidebar.jsp" %>
        </div>

        <!-- to display the list of products-->
        <div class="col-md-9">
            <!-- added breadcrum component-->
            <div class="row">
                <div class="col-lg-12">

                    <c:if test="${userClickAllProducts== true}">

                        <script>
                            window.categoryId='';
                        </script>

                    <ul class="breadcrumb">
                        <li><a href="${contextRoot}/home">Home</a></li>
                        <li class="active">All Products</li>
                    </ul>
                    </c:if>


                    <c:if test="${userClickCategoryProducts== true}">
                        <script>
                            window.categoryId='${category.id}';
                        </script>
                        <ul class="breadcrumb">
                            <li><a href="${contextRoot}/home">Home</a></li>
                            <li class="active">Category</li>
                            <li class="active">${category.name}</li>
                        </ul>
                    </c:if>



                </div>
            </div>

            <div class="col-xs-12">
                <table id="productListTable" class="table table-striped table-bordered">
                    <thead>
                        <tr>
                            <th></th>

                            <th>Name</th>
                            <th>Brand</th>
                            <th>Unit Price</th>
                            <th>Quantity</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="product" items="${products}">
                    <tr>
                        <td class="dataTableImg"><img src="${images}/${product.code}.jpg"></td>
                        <td>${product.name}</td>
                        <td>${product.brand}</td>
                        <td>${product.unitPrice}</td>

                        <c:choose>
                            <c:when test="${product.quantity<1}">
                            <td><span style="color: red">out of stock </span></td>
                                <td>
                                    <a href="/show/${product.id}/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a>
                                    <a href="javascript:void(0)" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"></span></a>
                                </td>
                        </c:when>
                         <c:otherwise>

                             <td><span>${product.quantity} </span></td>
                             <td>
                                 <a href="/show/${product.id}/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a>
                                 <a href="" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>
                             </td>
                         </c:otherwise>
                        </c:choose>

                    </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

    </div>

</div>

