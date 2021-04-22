let main = {
    init: function () {
        let _this = this;
        $('#btn-update').on('click', function (){
            _this.update();
        });
        $('#btn-delete').on('click', function () {
            _this.delete();
        });
        $('#btn-enroll').on('click', function (){
            _this.post();
        })
    },
    post: function(){
      let data = {
          name: $('#m_name').val(),
          age : parseInt($('#m_age').val()),
          address: {
              city: $('#m_city').val(),
              gu: $('#m_gu').val(),
              dong: $('#m_dong').val()
          },
          team_name: $('#m_team').val()
      }

      $.ajax({
            type: 'POST',
            url: `/api/member`,
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert('회원이 등록되었습니다.');
            window.location.href='/';
        }).fail(function (e){
            alert(JSON.stringify(e));
        });

    },
    update: function () {
        let data = {
            name: $('#name').val(),
            age : parseInt($('#age').val()),
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