  function login() {
      let name = $("#user-name").val();
      let pass = $("#user-password").val();
      $.post("/login",
          {
              user:name,
              pass:pass
          },
          function(data,status){
              let rs = JSON.parse(data);
              if (rs.success) {
                  window.location.replace(rs.url);
              }
          }
      );
  }