var app = new Vue({
    el: '#regist',
    data: {
        activeNameArray: '',
        collapseFlag: '',
        form: {}
    },
    mounted: function () {
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

        this.collapseFlag = this.activeNameArray = getUrlParams('role')
    },
    methods: {
        submitFn: function (val) {
            var requestUrl=""
            if (val == 1) {
                requestUrl="/user/insertAdminInfo"
            }else{
                requestUrl="/student/insertStudent"
            }
            $.ajax({
                url: requestUrl,
                contentType: "application/json;charset=UTF-8",
                type: "POST",
                data: JSON.stringify(this.form),
                success: function (result) {
                    window.location = "studentsManager/login.html";
                }
            });
        }
    }
})