$(function(){
    //solving the active menu problem
    console.log(menu);
    switch(menu){

        case 'About':
            $("#about").addClass('active');

            break;

        case 'Contact':
            $("#contact").addClass('active');
            break;

        case 'Home':
            $("#home").addClass('active');
            break;

        case 'All Products':
            $("#products").addClass('active');
            break;

        case 'Manage Products':
            $("#manageProducts").addClass('active');
            break;

        default:
            $("#id_"+menu).addClass('active danger');
            break;
    }
});