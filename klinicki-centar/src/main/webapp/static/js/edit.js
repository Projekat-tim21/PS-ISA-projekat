$(function () {
    $('.updateData').click(function () {
        console.log('updateData')
        var id = $(this).attr('id').substring(7);
        $('#fnaziv_' + id).hide();
        $('#text_fnaziv_' + id).show();
        $('#text_fnaziv_' + id).focus();
        $('#fdodatno_' + id).hide();
        $('#text_fdodatno_' + id).show();
        $(this).hide();
        $('#save_' + id).show();

    });

});