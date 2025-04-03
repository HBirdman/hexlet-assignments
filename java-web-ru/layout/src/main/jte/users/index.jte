@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
content = @`
    <h1>Список всех пользователей:</h1>
    @if(page.getUsers().isEmpty())
        <h2>Список пользователей пуст</h2>
    @else
        @for(var user : page.getUsers())
            <div>${user.getFirstName()}, ${user.getLastName()}</div>
        @endfor
    @endif
`,
header = @`
    <h1 href="/">Link to main page</h1>
    <h2 href="/users">Посмотреть список пользователей</h2>
`,
footer = @`
    <h1>This is the end.</h1>
`
)