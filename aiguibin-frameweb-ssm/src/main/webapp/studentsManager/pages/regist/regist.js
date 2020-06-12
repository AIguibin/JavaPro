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
        submitFn: function () {
            console.log('data')
            $.ajax({
                url: "http://127.0.0.1:8080/loginServlet",
                contentType:"application/json",
                type: "post",
                data: {
                    name: 'Jone',
                    age: 18
                },
                success: function (result) {
                    console.log(result)
                }
            });
        }
    }
})