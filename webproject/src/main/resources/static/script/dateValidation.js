/**
 * This is a java script demo for date validation in dd/mm/yyyy format
 * validation checks :
 *  date < 31
 *  month !> 12
 *  year between 1900 and 2100
 */

function isDate(date) {
	var n = date.value;
	var ans = 'y';
	var lNumber = n.substring(n.length - 1);
	var lLength = n.length;

	if (lLength < 3)
		ans = isNum(lNumber);
	else if (lLength > 3 && n.length < 6)
		ans = isNum(lNumber);
	else if (lLength > 6)
		ans = isNum(lNumber);

	if (ans == 'n') {
		alert("Enter a numeric value");
		date.value = n.substring(0, n.length - 1);
		date.focus();
	} else {
		if (lLength == 2) {
			if (inRange(n.substring(0, 2), 1) == 'y')
				date.value = n + '/';
			else {
				alert("Invalid day!");
				date.value = n.substring(0, 0);
				date.focus();
			}
		} else if (lLength == 5) {
			if (inRange(n.substring(3, 5), 2) == 'y')
				date.value = n + '/';
			else {
				alert("Invalid month!");
				date.value = n.substring(0, 3);
				date.focus();
			}
		} else if (lLength == 10) {
			if (checkWholeDate(n) == 'y')
				date.value = n;
			else {
				alert("Invalid date!");
				date.value = n.substring(0, 6);
				date.focus();
			}
		}
	}
}

function isNum(num) {
	var flag = 0;

	for (; flag < 10; flag++)
		if (num == flag)
			break;
	if (flag > 9)
		return 'n';
	else
		return 'y';
}

function inRange(num, caseNo) {

	switch (caseNo) {
		case 1: if (num >= "01" && num <= "31") return 'y'; break;
		case 2: if (num >= "01" && num <= "12") return 'y'; break;
	}
	return 'n';
}

function checkWholeDate(date) {
	var lDay = date.substring(0, 2);
	var lMonth = date.substring(3, 5);
	var nYear = parseInt(date.substring(6, 10));

	if (nYear < 1920) return 'n';

	if (lMonth == "02") {
		if (lDay <= "28")
			return 'y';
		else if ((lDay == "29") && (nYear % 4 == 0 && nYear % 100 != 0 || nYear % 400 == 0))
			return 'y';
		else
			return 'n';
	} else if ((lMonth == "04" || lMonth == "06" || lMonth == "09" || lMonth == "11") && (lDay > "30"))
		return 'n';
	else if (lDay > "31")
		return 'n';

	return 'y'
}
