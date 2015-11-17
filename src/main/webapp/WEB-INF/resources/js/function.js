/*
 * function.js requires below dependencies.
 * - moment.js
 * - numeral.js
 */
function formatDate(rawDate, locale) {
    if (locale && locale.match(/ko/i)) { // exceptional case for korea
        return moment.utc(rawDate).format("YYYY-MM-DD");
    } else {
        return moment.utc(rawDate).locale(locale).format("ll");
    }
}

function formatCurrency(rawNumeric, currencyCode) {
    var symbol;
    if (currencyCode === "KRW") {
        symbol = "&#8361;"; // won
    } else {
        symbol = "&#0036;"; // dollor
    }
    return symbol + numeral(rawNumeric).format('0,0[.]00');
}


function formatViewManuscriptButton(manuscriptId, pageType, v, message, width) {
    var w = width == undefined ? 135 : width;
    return "<button type='button' class='btn btn-default btn-xs actionButton width" + w + "' onClick='viewManuscript(" + manuscriptId + ", \"" + pageType + "\", \"" + v + "\");'/>" + message + "</button>";
}

function formatActionButton(manuscriptId, functionName, message, width) {
    var w = width == undefined ? 135 : width;
    return "<button type='button' class='btn btn-default btn-xs actionButton width" + w + "' onClick='" + functionName + "(" + manuscriptId + ");'/>" + message + "</button>";
}
