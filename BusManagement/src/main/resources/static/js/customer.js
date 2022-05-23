// var editor; // use a global for the submit and return data rendering in the examples
 
// URL="/admin/showCustomer"
// $(document).ready(function() {
//     editor = new $.fn.dataTable.Editor( {

//         ajax: {
//             URL:URL,
//             type:get,
//             dataSrc:function(json){
//                 return json;
//             }
//         },

//         // "columns":[{
//         //     "target":0,
//         //     "visible":true,
//         //     "width": 40,
//         //     "data":first_name
//         // }
//         // ],
//         table: "#example",
//         template: '#customForm',
//         fields: [ {
//                 label: "First name:",
//                 name: "firstName"
//             }, {
//                 label: "Last name:",
//                 name: "lastName"
//             }, {
//                 label: "Position:",
//                 name: "userName"
//             }, {
//                 label: "Office:",
//                 name: "password"
//             }, {
//                 label: "Extension:",
//                 name: "mobileNumber"
//             }, {
//                 label: "Start date:",
//                 name: "gender",
//                 type: "datetime"
//             }, {
//                 label: "Salary:",
//                 name: "age"
//             }
//         ]
//     } );
 
//     $('#example').DataTable( {
//         dom: "Bfrtip",
//         ajax: "/admin/showCustomer",
//         columns: [
//             { data: null, render: function ( data, type, row ) {
//                 // Combine the first and last names into a single table field
//                 return data.first_name+' '+data.last_name;
//             } },
//             { data: "position" },
//             { data: "office" },
//             { data: "extn" },
//             { data: "start_date" },
//             { data: "salary", render: $.fn.dataTable.render.number( ',', '.', 0, '$' ) }
//         ],
//         select: true,
//         buttons: [
//             { extend: "create", editor: editor },
//             { extend: "edit",   editor: editor },
//             { extend: "remove", editor: editor }
//         ]
//     } );
// } );


var table = $('#example').DataTable({
    "sAjaxSource": "/admin/getAllCustomer",
    "sAjaxDataProp": "",
    "order": [[ 0, "asc" ]],
    "aoColumns": [
        { "mData": "customerId"},
        { "mData": "firstName" },
        { "mData": "lastName" },
        { "mData": "userName" },
        { "mData": "password"},
        { "mData": "mobileNumber" },
        { "mData": "gender" },
        { "mData": "age" }

    ]
})