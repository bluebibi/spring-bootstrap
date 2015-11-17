/*
 * tableAjax.js requires function.js
 */
var TableAjax = function() {

    var _locale;

    var handleRecords = function(tableObject, ajaxUrl, dom) {
        var columns = parseColumns(tableObject);

        var grid = new Datatable();
        var tableDom = "<'row'<'col-md-8 col-sm-12'l><'col-md-4 col-sm-12'<'table-group-actions pull-right'>f>r><'table-responsive't><'row'<'col-md-8 col-sm-12'i><'col-md-4 col-sm-12 cellRight'p>>"; // datatable layout
        //var tableDom = '<"row"<"col-md-6 col-sm-12"l>>rt<"bottom"p><"clear">';
        if(dom) tableDom = dom;

        grid.init({
            src : tableObject,
            loadingMessage : ' ',
            dataTable : { // here you can define a typical datatable settings from http://datatables.net/reference/option/

                "dom" : tableDom,

                "language" : {
                    "lengthMenu" : "_MENU_",
                    "search" : "",
                    "info" : "_START_ - _END_ / _TOTAL_",
                    "sInfoFiltered" : "",
                    "emptyTable": "-",
                    "zeroRecords": "",
                    "infoEmpty": "",
                },
                "pagingType": "bootstrap_full_number", // pagination type(bootstrap, bootstrap_full_number or bootstrap_extended)
                ajax : {
                    url : ajaxUrl,
                    contentType : "application/json; charset=utf-8",
                    data : function(data) {
                        return JSON.stringify(data);
                    }
                },

                columns : columns,
                order : columns.order
            }
        });
        $('.dataTables_length select').addClass("form-control input-small marginRight30"); // modify table per page dropdown
        $('.dataTables_length select').select2(); // initialize select2 dropdown
        /*$(".dataTables_paginate").css("float", "right !important");*/

        /*$(tableObject).find('tbody').on('click', 'tr', function() {
         });*/
    }

    // parsing custom column-* attributes based on html5 data-* attributes
    function parseColumns(tableObject) {
        var columns = [];
        columns.order = [];

        $(tableObject).find("tr > td").each(function(index) {
            /*
             in html.
             data-column-data="productId"

             in original datatables option.
             column: [
             {
             data: "productId",
             }
             ]
             */
            var column = {
                name : $(this).data("column-name"),
                data : $(this).data("column-data"),
                visible : $(this).data("column-visible"),
                searchable : $(this).data("column-searchable"),
                orderable : $(this).data("column-orderable"),
                sClass : $(this).data("column-class") || "cellCenter",
                render : eval($(this).data("column-render")) || null
            }
            columns.push(column);

            /*
             in html.
             data-column-order="desc"

             in original datatables option. 순서 주의. 현재 작성 순서대로 정렬 우선순위.
             order: [
             [1, "desc"]
             ]
             */
            if ($(this).data("column-order")) {
                columns.order.push([ index, $(this).data("column-order") ]);
            }
        });

        return columns;
    }


    function renderDate(data, type, row) {
        // If display or filter data is requested, format the date
        if (type === "display" || type === "filter") {
            return formatDate(data, _locale);
        }

        // Otherwise the data type requested (`type`) is type detection or
        // sorting data, for which we want to use the integer, so just return
        // that, unaltered
        return data;
    }

    function renderCurrency(data, type, row) {
        return formatCurrency(data, row.currency);
    }

    // 어떤 함수든 global로 작성한 후 그냥 data-column-render="renderCustom" 이렇게 실행 할 수 있음. 위의 renderXXX는 predefined라고 보면 됨.

    return {
        init : function(tableObject, ajaxUrl, locale, dom) {

            _locale = locale;

            handleRecords(tableObject, ajaxUrl, dom);
        }
    };

}();
