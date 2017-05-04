/**
 * Created by peiji on 2017/5/4.
 */
/**
 * Created by songshuang on 16/3/21.
 */
/**
 * js 前端公共工具对象
 */
define(function (require, exports, module) {

    "use strict";

    var $ = require('jquery');
    require("overChange");

    function showPage() {
        $(document.head).append("<link rel='stylesheet' href='/static/css/pageStyle.css'>");
        var total = $('#pageDiv').data().total; // 总共多少条数据
        var pageNum = $('#pageResultNo').val();

        pageNum = parseInt(pageNum);
        if (pageNum == "" || pageNum == 0 || pageNum == void 0) {
            pageNum = 0;
        }
        var totalPages = Math.floor(total / 20);
        //if ((total % 20 > 0) && (total % 20 < 5)) {
        if ((total % 20 > 0)) {
            totalPages += 1;
        }
        var str = '<span class="activePage" style="font-size: 20px;color: #008A03;margin-left: 4px;" >' + pageNum + '</span>';
        if (total == "" || total == 0 || total == void 0) {
            str = "暂无数据"
        }
        /**
         * 首页链接
         * @type {string}
         */
        var firstPage = '';
        if (totalPages > 2 && pageNum != 1) {
            firstPage = '<a class="pageNo" style="font-size: 20px" data-id="1">首页</a>';
        }
        /**
         * 尾页链接
         */
        var lastPage = '';
        if (totalPages > 2 && pageNum != totalPages) {
            lastPage = '<a class="pageNo" style="font-size: 20px;margin-left: 6px;" data-id="'+totalPages+'">尾页</a>';
        }

        for (var i=1; i<3; i++) {
            if (pageNum-i > 1) {
                str = '<a  class="pageNo" style="font-size: 20px;margin-left: 4px;" data-id="'+(pageNum - i) +'"><span>' + (pageNum - i) + '</span></a>' + str;
            }
            if (pageNum + i < totalPages) {
                str = str + '<a class="pageNo" style="font-size: 20px;margin-left: 4px;" data-id="'+(pageNum + i) +'"><span>' + (pageNum + i) + '</span></a>';
            }
        }
        if (pageNum > 1) {
            str = firstPage + '<a id="prevPage" style="font-size: 20px;margin-left: 6px;">&lt;&nbsp;<span>上一页</span></a>' + str;
        }

        if (pageNum + 3 < totalPages) {
            str = str + ' ...';
        }

        if (pageNum < totalPages) {
            str = str + ' <a class="pageNo" style="font-size: 20px" data-id="'+totalPages+'"><span>' + totalPages + '</span></a><a id="nextPage" style="font-size: 20px;margin-left: 4px;">下一页&nbsp;&gt;</a>' + lastPage;
        }
        $('#pageDiv').html(str);
        /**
         * 用于控制是否是表单按钮所触发还是链接按钮触发
         * @type {boolean}
         */
        var TRIGGER_FLAG = false;

        /**
         * 跳转到指定页面
         */
        $(document).on('click', '.pageNo', function () {
            $('#pageResultNo').val();
            var pageNo = $(this).data().id;
            $('#pageResultNo').val(pageNo);
            TRIGGER_FLAG = true;
            $('#J_Search').click();
        });
        /**
         * 跳转到下一页
         */
        $(document).on('click', '#nextPage', function () {
            var pageNo = $('#pageResultNo').val();
            pageNo = parseInt(pageNo) + 1;
            $('#pageResultNo').val(pageNo);
            TRIGGER_FLAG = true;
            $('#J_Search').click();
        });
        /**
         * 跳转到上一页
         */
        $(document).on('click', '#prevPage', function () {
            var pageNo = $('#pageResultNo').val();
            pageNo = parseInt(pageNo) - 1;
            $('#pageResultNo').val(pageNo);$('#pageResultNo').val();
            TRIGGER_FLAG = true;
            $('#J_Search').click();
        });

        $('#J_Search').on('click', function () {
            var pageNo = $('#pageResultNo').val();
            /**
             * 当时表单按钮触发的时候,需要将页码设置为第一页
             */
            if (pageNo == "" || pageNo == 0 || pageNo == void 0 || !TRIGGER_FLAG) {
                $('#pageResultNo').val(1);
            }
        });
    }

    function dateTool(date) {

    }

    function upload(name) {

    }

    function ajaxGet(url, data, cb) {

        if ($('.clickBtn').hasClass('btn-default')) {
            return false;
        }

        var ret = $.ajax({
            url: url,
            type: 'GET',
            data: data,
            timeout: 60003000
        })
            .done(function (data) {
                if (typeof($('.clickBtn')) != void 0 && typeof($(".clickBtn")) == "object") {
                    $('.clickBtn').each(function() {
                        var self = $(this);
                        if (self.hasClass('btn-default')) {
                            $('.clickBtn').addClass('btn-success').removeClass('btn-default');
                            if (self.data('btnText') != void 0 && self.data('btnText') != "") {
                                self.text(self.data('btnText')).css({color: '#fff'});
                            } else {
                                self.text('确定').css({color: '#fff'});
                            }
                        }
                    });
                }
                if (data.success) {
                    if (typeof cb === "function") {
                        if (data.hasOwnProperty("result")) {
                            cb(data.result);
                        } else {
                            cb(data);
                        }
                    }
                } else {
                    if (data.hasOwnProperty('msg') && data.msg != void 0 && data.msg.length > 0) {
                        alert(data.msg);
                        window.location.reload();
                    } else if (data.hasOwnProperty('message') && data.message.length > 0) {
                        alert(data.message);
                        window.location.reload();
                    } else {
                        alert("请求失败!");
                        window.location.reload();
                    }
                }
            })
            .error(function (error) {
                if (typeof($('.clickBtn')) != void 0 && typeof($(".clickBtn")) == "object") {
                    $('.clickBtn').addClass('btn-success').removeClass('btn-default').text('确定').css({color: '#fff'});
                }
                if (error.status == 401) {
                    alert("对不起,您没有权限操作");
                } else {
                    alert("网络错误");
                }

            });
    }

    function ajaxPost(url, data, cb) {
        event.preventDefault();

        if ($(this).hasClass('btn-default')) {
            return false;
        }

        var ret = $.ajax({
            url: url,
            type: 'POST',
            contentType: 'application/json',
            dataType: 'json',
            data: JSON.stringify(data)
        }).
        done(function (data) {
            if (typeof($('.clickBtn')) != void 0 && typeof($(".clickBtn")) == "object") {
                var self = $(this);
                if (self.hasClass('btn-default')) {
                    $('.clickBtn').addClass('btn-success').removeClass('btn-default');
                    if (self.data('btnText') != void 0 && self.data('btnText') != "") {
                        self.text(self.data('btnText')).css({color: '#fff'});
                    } else {
                        self.text('确定').css({color: '#fff'});
                    }
                }
            }
            if (data.success) {
                if (typeof cb == 'function') {
                    cb(data.result);
                }
            } else {
                if (data.hasOwnProperty('msg') && data.msg != void 0 && data.msg.length > 0) {
                    alert(data.msg);
                    window.location.reload();
                } else if (data.hasOwnProperty('message') && data.message.length > 0) {
                    alert(data.message);
                    window.location.reload();
                } else {
                    alert("请求失败!");
                    window.location.reload();
                }
            }
        })
            .error(function (error) {
                if (typeof($('.clickBtn')) != void 0 && typeof($("#chekc")) == "object") {
                    $('.clickBtn').addClass('btn-success').removeClass('btn-default').text('确定').css({color: '#fff'});
                }

                if (error.status == 401) {
                    alert("对不起,您没有权限操作");
                } else {
                    alert("网络错误");
                    window.location.reload();
                }
            });
    }


    ;function iframeDialog(classArr){
        $.each($(classArr),function (i,className) {
            var id=$(className).data('aid'),
                newClass=id+'Mask';
            if(!$("[data-id='" + id + "']").prev().hasClass('maskWrap')){
                $("[data-id='" + id + "']").before('<div class="maskWrap ' + newClass + '"></div>');
            }
        });
        $(classArr).on('click',function (e) {
            $('body').css('overflow','hidden');
            e.preventDefault();
            $('.loadGif').remove();
            var load="<img src='/images/loading-0.gif' class='loadGif'/>";
            var did=$(this).data('aid'),
                dnewClass=did+'Mask',
                frameSrc=$(this).data('src'),
                iframeObj=$("[data-id='"+did+"']").find('iframe');
            $("[data-id='"+did+"']").find('.modalTitle').after(load);
            iframeObj[0].src=frameSrc;
            iframeObj[0].onload=function(){
                $('.loadGif').remove();
            };
            iframeObj.show();
            $("[data-id='"+did+"']").show().prev('.maskWrap.'+dnewClass+'').show();
        });
        $('.xubox_close').on('click',function(){
            $('body').css('overflow','auto');
            var currentNode=$(this).closest('.iframeModal'),
                maskClass=currentNode.attr('data-id')+'Mask';
            currentNode.hide().prev('.maskWrap.'+maskClass).hide();
            currentNode.find('iframe')[0].src='';
            $('.loadGif').remove();
        });
        $('.maskWrap').on('click',function () {
            $('body').css('overflow','auto');
            var currentMask=$(this);
            currentMask.hide().next('.iframeModal').hide().find('iframe')[0].src='';
            $('.loadGif').remove();
        });
    };

    function getQueryString(name) {
        if (window.location.href.indexOf("?") != window.location.href.lastIndexOf("?"))
            var urls = window.location.href.replace(/\?/g, "&").replace(/^.*?&/, "")
        else
            var urls = window.location.href.replace(/^.*\?/, "");
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
        var r = ("?" + urls).substr(1).match(reg);
        if (r != null) return unescape(r[2]);
        return null;
    }

    function alertFunction() {

    }
    // 提示框(成功)
    alertFunction.prototype.alert = function (message, cb) {
        $("body").overhang({
            easing: "",
            message: message,
            speed: "400",
            custom: true, // Set custom to true
            primary: "#34495E", // Your custom primary color
            accent: "#F4B350", // Your custom accent color
            callback: cb
        });
    };

    // 提示框(失败, 报错)
    alertFunction.prototype.error = function (message, cb) {
        $("body").overhang({
            easing: "",
            type: "error",
            message: message,
            speed: "400",
            closeConfirm: "true",
            callback: cb
        });
    };
    // 添加模块, 当按钮点击的时候, 不能继续点击
    $(document).on('clickPrevent', '.clickBtn', function(){
        if ($(this).data('btnText') == void 0 || $(this).data('btnText') == "") {
            $(this).data().btnText = $(this).text();
        }
        $(this).addClass('btn-default').removeClass('btn-success').text('正在提交...').css({color: '#666'});
    });

    var MaiHaoCheTools = {
        dateTool: dateTool,
        showPage: showPage,
        ajaxGet: ajaxGet,
        ajaxPost: ajaxPost,
        iframeDialog:iframeDialog,
        getQueryString:getQueryString,
        windowPrompt: new alertFunction()
    };

    module.exports = MaiHaoCheTools;
});
