let main = {
    init: function () {
        let _this = this;
        $('#btn-update').on('click', function (){
            _this.update();
        });
        $('#btn-delete').on('click', function () {
            _this.delete();
        });
    },
    update: function () {
        let data = {
            name: $('#name').val(),
            age : $('#age').val(),
            city: $('#city').val(),
            gu: $('#gu').val(),
            dong: $('#dong').val(),
            team_name: $('#team').val()
        };

        let id = $('#id').val();
        $.ajax({
            type: 'PUT',
            url: `/api/member/${id}`,
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert('글이 수정 되었습니다.');
            window.location.href='/';
        }).fail(function (e){
            alert(JSON.stringify(e));
        });
    },
    delete: function (){
        let id = $('#id').val();
        $.ajax({
            type: 'DELETE',
            url: `/api/member/${id}`,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
        }).done(function () {
            alert('글이 삭제 되었습니다.');
            window.location.href='/';
        }).fail(function (e) {
            alert(JSON.stringify(e));
        })
    }
}

main.init();