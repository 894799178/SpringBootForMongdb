
$(function() {

    let uploader = WebUploader.create({
        // 文件接收服务端。
        server: '/gServerUpdate/uploadExcel',
        // 选择文件的按钮。可选。
        // 内部根据当前运行是创建，可能是input元素，也可能是flash.
        pick: '#picker',
        accept:{
            title: 'file',
            extensions: 'xlsx',
            mimeTypes: 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet'
        },
        // 不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传！
        resize: false
    });

    // 当有文件被添加进队列的时候
    uploader.on( 'fileQueued', function( file ) {
        $("#thelist").append( '<div id="' + file.id + '" class="item">' +
            '<span class="info" style="font-weight: bold ">' + file.name + '</span>' +
            '<span class="state" style="color: blue;"> 等待上传...</span>' +
            '</div>' );
    });

    uploader.on( 'uploadProgress', function( file, percentage ) {
        let $li = $( '#'+file.id );
        $li.find('p.state').text('上传中 ..当前进度'+(percentage * 100)+'%');
    });

    uploader.on( 'uploadSuccess', function( file ) {
        $( '#'+file.id ).find('span.state').text(' 已上传');
        $( '#'+file.id ).find('span.state').css('color','green');
    });

    uploader.on( 'uploadError', function( file ) {
        $( '#'+file.id ).find('span.state').text(' 上传出错');
        $( '#'+file.id ).find('span.state').css('color','green');
    });

    uploader.on( 'uploadComplete', function( file ) {
        //$( '#'+file.id ).find('.progress').fadeOut();
    });

    $("#ctlBtn").on("click",function(){
        uploader.upload();
    })

});

function makeCfg(){
    $.getJSON("/gServerUpdate/excel2Cfg",function(result){
        //alert(JSON.stringify(result));
        $( '#consoleLog').val(result.msg);
    });
    $( '#consoleLog').val("正在转换。。。。。!时间比较长请耐心等待！");
}

function startServer(){
    $( '#consoleLog').val("发送启动服务器请求。。。。。。");
    $.getJSON("/gServerUpdate/ctrl?state=start",function(result){
        //alert(JSON.stringify(result));
        $( '#consoleLog').val(result.msg);
    });
}

function stopServer(){
    $( '#consoleLog').val("发送关闭服务器请求。。。。。。");
    $.getJSON("/gServerUpdate/ctrl?state=stop",function(result){
        //alert(JSON.stringify(result));
        $( '#consoleLog').val(result.msg);
    });
}

function listServer(){
    $.getJSON("/gServerUpdate/ctrl?state=list",function(result){
        //alert(JSON.stringify(result));
        $( '#consoleLog').val(result.msg);
    });
}