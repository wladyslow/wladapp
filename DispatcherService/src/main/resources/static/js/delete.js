$(function () {
    $("a[id^=del]").click(function (event) {
        if (confirm('Are you sure to delete this city?')) {
            let cityId = $(this).attr('name').replace('del', '');
            $.ajax({
                url: '/cities/' + cityId,
                type: 'DELETE',
                success: function (result) {
                    if (result.success) {
                        location.href = '/cities';
                    }
                }
            });
        }
        event.preventDefault();
    });
});