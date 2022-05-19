$(document).ready(function() {
    var currencies =
        [{name: 'Австралийский доллар', value: 'AUD'},
            {name: 'Азербайджанский манат', value: 'AZN'},
            {name: 'Армянский драм', value: 'AMD'},
            {name: 'Белорусский рубль', value: 'BYN'},
            {name: 'Болгарский лев', value: 'BGN'},
            {name: 'Бразильский реал', value: 'BRL'},
            {name: 'Венгерский форинт', value: 'HUF'},
            {name: 'Вон Республики Корея', value: 'KRW'},
            {name: 'Гонконгский доллар', value: 'HKD'},
            {name: 'Датская крона', value: 'DKK'},
            {name: 'Доллар США', value: 'USD'},
            {name: 'Евро', value: 'EUR'},
            {name: 'Индийская рупия', value: 'INR'},
            {name: 'Казахстанский тенге', value: 'KZT'},
            {name: 'Канадский доллар', value: 'CAD'},
            {name: 'Киргизский сом', value: 'KGS'},
            {name: 'Китайский юань', value: 'CNY'},
            {name: 'Молдавский лей', value: 'MDL'},
            {name: 'Новый туркменский манат', value: 'TMT'},
            {name: 'Норвежская крона', value: 'NOK'},
            {name: 'Польский злотый', value: 'PLN'},
            {name: 'Российский рубль', value: 'RUB'},
            {name: 'Румынский лей', value: 'RON'},
            {name: 'СДР (специальные права заимствования)', value: 'XDR'},
            {name: 'Сингапурский доллар', value: 'SGD'},
            {name: 'Таджикский сомони', value: 'TJS'},
            {name: 'Турецкая лира', value: 'TRY'},
            {name: 'Узбекский сум', value: 'UZS'},
            {name: 'Украинская гривна', value: 'UAH'},
            {name: 'Фунт стерлингов Соединенного королевства', value: 'GBP'},
            {name: 'Чешская крона', value: 'CZK'},
            {name: 'Шведская крона', value: 'SEK'},
            {name: 'Швейцарский франк', value: 'CHF'},
            {name: 'Южноафриканский рэнд', value: 'ZAR'},
            {name: 'Японская иена', value: 'JPY'}];


    var objSel = document.getElementById("currency1");
    for (var i in currencies) {
        var option = document.createElement("option");
        option.setAttribute("value", currencies[i].value);
        option.text = currencies[i].name;
        objSel.appendChild(option);
    }
    var objSel1 = document.getElementById("currency2");
    for (var i in currencies) {
        var option = document.createElement("option");
        option.setAttribute("value", currencies[i].value);
        option.text = currencies[i].name;
        objSel1.appendChild(option);
   }
})