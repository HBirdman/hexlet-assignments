@import exercise.dto.posts.PostPage
@import exercise.util.NamedRoutes
@param PostPage page

<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
          crossorigin="anonymous">
    <title>Hello Hexlet!</title>
</head>
<body>
<div class="mx-auto p-4 py-md-5">
    <main>
        <h1>${page.getPost().getName()}</h1>
        <a>${page.getPost().getBody()}</a>
    </main>
</div>
<h2 href="${NamedRoutes.postsPath()}">Вернуться на главную</h2>
</body>
</html>
