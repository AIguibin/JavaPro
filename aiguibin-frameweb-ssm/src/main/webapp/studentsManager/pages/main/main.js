var app = new Vue({
    el: '#app',
    data: {
        activeNameArray: 'activeName',
        activeNameString: '',
        collapseTitle: '',
        tableData: [],
        formData: {},
        userType: '',
        adminNum: '',
        studentNum: '',
        radio:"",
        dialogFormVisible:false,
        formStudentInfo:{},
        selections:[]
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

        this.userType = getUrlParams('userType')
        this.adminNum = getUrlParams('adminNum')
        this.studentNum = getUrlParams('studentNum')
    },
    methods: {

        selectFn(menuItem) {
            if (menuItem.index == '1') {
                this.collapseTitle = '个人中心';
                this.activeNameString = 'adminInfo'
                this.formData = this.getFormDataFn(this.userType, this.adminNum);
            }
            if (menuItem.index == '2') {
                this.collapseTitle = '考生信息';
                this.activeNameString = 'adminCenter'
                this.tableData = this.getTableDataFn();
            }
            if (menuItem.index == '5') {
                this.collapseTitle = '个人中心';
                this.activeNameString = 'studentInfo'
                this.tableData = this.getFormDataFn(this.userType, this.studentNum);
            }
            if (menuItem.index == '3' || menuItem.index == '6') {
                this.collapseTitle = '修改密码';
                this.activeNameString = 'password'
            }
            if (menuItem.index == '4' || menuItem.index == '7') {
                if (confirm("您确定要退出登录吗？")) {
                    window.opener = null;
                    window.location.href = "studentsManager/login.html";
                }
            }


        },
        handleOpen(key, keyPath) {
            console.log(key, keyPath);
        },
        handleClose(key, keyPath) {
            console.log(key, keyPath);
        },
        // 编辑学生信息
        adminEdit() {
            var _this=this;
            if (_this.selections.length!=1) {
                _this.$message({
                    message: '请选择一条数据',
                    type: 'warning'
                });
                return;
            }
            _this.dialogFormVisible=true;
            _this.$nextTick(function () {
                _this.formStudentInfo=_this.selections[0];
            })
        },
        // 删除学生信息
        adminDelete() {
            var _this=this;
            if (_this.selections.length!=1) {
                _this.$message({
                    message: '请选择一条数据',
                    type: 'warning'
                });
                return;
            }
            $.ajax({
                url: "/student/getAllStudent",
                type: "POST",
                async: false,
                success: function (result) {
                    // 刷新学生信息表
                    _this.$nextTick(function () {
                        $.ajax({
                            url: "/student/getAllStudent",
                            type: "GET",
                            async: false,
                            success: function (result) {
                                _this.$nextTick(function () {
                                    _this.tableData = result;
                                })
                            }
                        });
                    })
                }
            });
        },
        handleSizeChange(index, row) {
            console.log(index, row);
        },
        handleCurrentChange(index, row) {
            console.log(index, row);
        },
        getCurrentRow: function (row) {
            this.selections=[];
            this.selections.push(row);
        },
        getTableDataFn: function () {
            var _this = this;
            $.ajax({
                url: "/student/getAllStudent",
                type: "GET",
                async: false,
                success: function (result) {
                    _this.$nextTick(function () {
                        _this.tableData = result;
                    })
                }
            });
        },
        getFormDataFn: function (userType, userNum) {
            var _this = this;
            var requestUrl = userType == "admin" ? "/user/getAdminInfo?adminNum=" : "/student/getStudentInfo?studentNum=";
            $.ajax({
                url: requestUrl + userNum,
                type: "GET",
                success: function (result) {
                    _this.$nextTick(function () {
                        _this.formData = result;
                    })
                }
            });
        },
        saveFn: function () {

        }
    }
})