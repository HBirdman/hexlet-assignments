@import gg.jte.Content

@param Content content
@param Content header
@param Content footer

<!doctype html>
<html lang="en">
    <head>
            <meta charset="utf-8" />
            <meta name="viewport" content="width=device-width, initial-scale=1" />
            <title>Main Page</title>
            ${header}
    </head>
    <body>
        <p>
            ${content}
            ${footer}
        </p>
    </body>
</html>