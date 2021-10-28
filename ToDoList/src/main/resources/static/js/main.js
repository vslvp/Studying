$(function(){

    const appendToDo = function(data){
        var toDoCode = '<a href="#" class="todo-link" data-id="' + data.id + '">' + data.name + '</a><br>';
        $('#todo-list')
            .append('<div>' + toDoCode + '</div>');
    };

    $.get('todos', function(response)){
        for(i in response){
            appendToDo(response[i]);
        }
    });

    $('#show-add-todo-form').click(function(){
        $('#todo-form').css('display', 'flex');
    });

    $('#todo-form').click(function(event){
        if(event.target === this)
            $(this).css('display', 'none');
    });

    $('save-todo').click(function(){
        var data = $('#todo-form form').serialize();
        $.ajax({
            method: "POST",
            url: '/todos/',
            data: data,
            success: function(response){
                $('#todo-form').css('display', 'none');
                var todo = {};
                todo.id = response.id;
                var dataArray = $('#todo-form form').serializeArray();
                for(i in dataArray){
                    todo[dataArray[i]['name']] = dataArray[i]['value'];
                }
                appendToDo(todo);
            }
            });
            return false;
});
});
