/**
 * 格式化日期
 * @param date
 * @param separator
 * @returns {*}
 */
function myDateFormat(date,separator){
    return date.getFullYear()+separator+(date.getMonth()+1)+separator+date.getDate();
}

/**
 * 字符串转日期
 * @param dateStr
 * @param separator
 * @returns {Date}
 */
function stringToDate(dateStr,separator){
    if(!separator){
        separator="-";
    }
    let dateArr = dateStr.split(separator);
    let year = parseInt(dateArr[0]);
    let month;
    //处理月份为04这样的情况
    if(dateArr[1].indexOf("0") === 0){
        month = parseInt(dateArr[1].substring(1));
    }else{
        month = parseInt(dateArr[1]);
    }
    let day = parseInt(dateArr[2]);
    return new Date(year,month -1,day);
}

Date.prototype.format = function(format)
{
    var o = {
        "M+" : this.getMonth()+1, //month
        "d+" : this.getDate(),    //day
        "h+" : this.getHours(),   //hour
        "m+" : this.getMinutes(), //minute
        "s+" : this.getSeconds(), //second
        "q+" : Math.floor((this.getMonth()+3)/3),  //quarter
        "S" : this.getMilliseconds() //millisecond
    }
    if(/(y+)/.test(format)) format=format.replace(RegExp.$1,
        (this.getFullYear()+"").substr(4 - RegExp.$1.length));
    for(var k in o)if(new RegExp("("+ k +")").test(format))
        format = format.replace(RegExp.$1,
            RegExp.$1.length==1 ? o[k] :
                ("00"+ o[k]).substr((""+ o[k]).length));
    return format;
}