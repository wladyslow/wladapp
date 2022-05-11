$(function () {
    $('#convert').click(function (){
        let date = $('#date').val();
        let currency1 = $('#currency1').val();
        let quantity = $('#quantity').val();
        let currency2 = $('#currency2').val();
        if (!date) {
            $('#date').css("border-color", "red");
        } else {
            $('#date').css("border", "black");
        }

        if (!currency1) {
            $('#currency1').css("border-color", "red");
        } else {
            $('#currency1').css("border", "black");
        }

        if (!quantity) {
            $('#quantity').css("border-color", "red");
        } else {
            $('#quantity').css("border", "black");
        }

        if (!currency2) {
            $('#currency2').css("border-color", "red");
        } else {
            $('#currency2').css("border", "black");
        }

        if (!currency1 || !date || !currency2 || !quantity) {
            alert('Введите значения!')
            return;
        }

        $.ajax({
            url: '/converter/convert?date=' + date + '&currency1=' + currency1 + '&quantity=' + quantity + '&currency2=' + currency2,
            type: 'POST',
            success: function (result) {
                $('#result').text('На ' + date + ' ' + quantity + ' ' + currency1 + ' равны ' +result + ' ' + currency2);

            }
        });
    });
});