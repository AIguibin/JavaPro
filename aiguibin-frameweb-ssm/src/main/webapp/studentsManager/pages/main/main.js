var app = new Vue({
    el: '#app',
    data: {
        activeNameArray: 'activeName',
        activeNameString: '',
        collapseTitle: '',
        formPassData: {},
        tableData: [],
        formData: {},
        userType: '',
        adminNum: '',
        studentNum: '',
        radio: "",
        dialogFormVisible: false,
        formStudentInfo: {},
        studentFormData: {},
        studentPassData:{},
        selections: []
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

        if (this.userType=='admin'){
            var menuItem={
                index:'1'
            }
        } else{
            var menuItem={
                index:'5'
            }
        }
        this.selectFn(menuItem);
    },
    methods: {

        selectFn(menuItem) {
            if (menuItem.index == '1') {
                this.collapseTitle = '个人中心';
                this.activeNameString = 'adminInfo'
                this.formData = this.getFormDataFn(this.userType, this.adminNum)||{};
            }
            if (menuItem.index == '2') {
                this.collapseTitle = '考生信息';
                this.activeNameString = 'adminCenter'
                this.tableData = this.getTableDataFn();
            }
            if (menuItem.index == '5') {
                this.collapseTitle = '个人中心';
                this.activeNameString = 'studentInfo'
                this.studentFormData = this.getFormDataFn(this.userType, this.studentNum)||{};
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
            var _this = this;
            if (_this.selections.length != 1) {
                _this.$message({
                    message: '请选择一条数据',
                    type: 'warning'
                });
                return;
            }
            _this.dialogFormVisible = true;
            _this.$nextTick(function () {
                _this.formStudentInfo = _this.selections[0];
            })
        },
        saveStudentInfo() {
            var _this = this;
            $.ajax({
                url: "/user/updateStudentInfo",
                contentType: "application/json;charset=UTF-8",
                type: "POST",
                data: JSON.stringify(_this.formStudentInfo),
                async: false,
                success: function (result) {
                    _this.$nextTick(function () {
                        $.ajax({
                            url: "/student/getAllStudent",
                            type: "GET",
                            async: false,
                            success: function (result) {
                                _this.$nextTick(function () {
                                    _this.tableData = result;
                                    _this.dialogFormVisible = false;
                                })
                            }
                        });
                    })
                }
            });
        },
        // 删除学生信息
        adminDelete() {
            var _this = this;
            if (_this.selections.length != 1) {
                _this.$message({
                    message: '请选择一条数据',
                    type: 'warning'
                });
                return;
            }
            $.ajax({
                url: "/user/deleteStudent?studentNum=" + _this.selections[0].studentNum,
                type: "GET",
                success: function (result) {
                    // 刷新学生信息表
                    _this.$nextTick(function () {
                        $.ajax({
                            url: "/student/getAllStudent",
                            type: "GET",
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
            this.selections = [];
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
                async:false,
                success: function (result) {
                    _this.$nextTick(function () {
                        if (userType == "admin") {
                        _this.formData = result;
                        }else{
                            _this.studentFormData=result;
                        }
                    })
                }
            });
        },
        updatePass: function () {
            var _this = this;
            if (_this.formPassData.oldPassWord != '123456') {
                _this.$message({
                    message: '原密码错误，请重新输入原密码',
                    type: 'warning'
                });
                return;
            }
            if (_this.formPassData.adminPass != _this.formPassData.adminPassAgain) {
                _this.$message({
                    message: '两次输入不一致，请重新输入密码',
                    type: 'warning'
                });
                return;
            }
            $.ajax({
                url: "/user/updateAdminInfo?password=" + _this.formPassData.adminPass + "&adminNum=admin",
                type: "GET",
                success: function (result) {
                    _this.$message({
                        message: '密码修改成功',
                        type: 'success'
                    });
                }
            });
        },
        updateStudentPass:function () {
            var _this = this;
            if (_this.studentPassData.oldPassWord != '123456') {
                _this.$message({
                    message: '原密码错误，请重新输入原密码',
                    type: 'warning'
                });
                return;
            }
            if (_this.studentPassData.studentPass != _this.studentPassData.studentPassAgain) {
                _this.$message({
                    message: '两次输入不一致，请重新输入密码',
                    type: 'warning'
                });
                return;
            }
            $.ajax({
                url: "/student/updateStudentPass?password=" + _this.studentPassData.studentPass + "&studentNum=student",
                type: "GET",
                success: function (result) {
                    _this.$message({
                        message: '密码修改成功',
                        type: 'success'
                    });
                }
            });
        }
    }
})