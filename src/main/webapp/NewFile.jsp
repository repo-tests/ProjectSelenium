<html>
<head><script>(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = "//connect.facebook.net/fr_FR/all.js#xfbml=1&appId=368166663296265";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));

var sharer = "https://www.facebook.com/sharer/sharer.php?u=";
window.open(sharer + location.href, 'sharer', 'width=626,height=436');
</script></head>
<body>
<div id="fb-root"></div>
<iframe src="https://www.facebook.com/plugins/registration?
             client_id=113869198637480&
             redirect_uri=https%3A%2F%2Fdevelopers.facebook.com%2Ftools%2Fecho%2F&
             fields=name,birthday,gender,location,email"
        scrolling="auto"
        frameborder="no"
        style="border:none"
        allowTransparency="true"
        width="100%"
        height="330">
</iframe>
</body>
</html>