var app = new Vue({
    el: '#app',
    data: {
        activeNameArray: 'activeName',
        activeNameString:'',
        collapseTitle: '',
        tableData: [],
        formData: {},
        userName: ''
    },
    mounted: function () {
        console.log(window.location.href);

        function getUrlParams(params) {
            var urlObj = {};
            if (!window.location.search) {
                return false;
            }
            var urlParams = window.location.search.substring(1);
            var urlArr = urlParams.split('&');
            for (var i = 0; i < urlArr.length; i++) {
                var urlArrItem = urlArr[i].split('=');
                urlObj[urlArrItem[0]] = urlArrItem[1]
            } // 判断是否有参数
            if (arguments.length >= 1) {
                return urlObj[params]
            }
            return urlObj;
        }
        this.userName = getUrlParams('name')
    },
    methods: {

        selectFn(menuItem) {
            if (menuItem.index == '1') {
                this.collapseTitle = '个人中心';
                this.activeNameString = 'adminInfo'
                this.formData = this.getFormDataFn('admin');
            }
            if (menuItem.index == '2') {
                this.collapseTitle = '学生信息';
                this.activeNameString = 'adminCenter'
                this.tableData = this.getTableDataFn('admin');
            }
            if (menuItem.index == '4') {
                this.collapseTitle = '个人中心';
                this.activeNameString = 'studentInfo'
                this.tableData = this.getFormDataFn('student');
            }
            if (menuItem.index == '5') {
                this.collapseTitle = '成绩信息';
                this.activeNameString = 'studentInfo'
                this.tableData = this.getTableDataFn('student');
            }
            if (menuItem.index == '3' || menuItem.index == '6') {
                if (confirm("您确定要关闭本页吗？")) {
                    window.opener = null;
                    window.open('', '_self');
                    window.close()
                }
            }


        },
        handleOpen(key, keyPath) {
            console.log(key, keyPath);
        },
        handleClose(key, keyPath) {
            console.log(key, keyPath);
        },
        handleEdit(index, row) {
            console.log(index, row);
        },
        handleDelete(index, row) {
            console.log(index, row);
        },
        getTableDataFn: function (name) {
            var tableArray = []

            for (var i = 0; i < 18; i++) {
                tableArray.push({
                    date: '2016-05-02',
                    name: name + i,
                    address: '上海市普陀区金沙江路 1518 弄'
                })
            }
            return tableArray;
        },
        getFormDataFn: function (name) {
            var tableArray = []
            return tableArray;
        },
        saveFn: function () {

        }
    }
})