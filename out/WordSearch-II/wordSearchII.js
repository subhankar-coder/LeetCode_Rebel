function findWords(board, words) {
    var map = new Map();
    var boardRow = board.length;
    var boardCol = board[0].length;
    var result = [];
    for (var i = 0; i < boardRow; i++) {
        for (var j = 0; j < boardCol; j++) {
            var key = board[i][j];
            if (map.get(key) != null || undefined) {
                var array = map.get(key);
                array.push([i, j]);
                map.set(key, array);
            }
            else {
                var array = [];
                array.push([i, j]);
                map.set(key, array);
            }
        }
    }
    var isFound;
    words.forEach(element => {
        isFound = false;
        var dupMap = copyMap(map);
        var index = 0;
        if (element.length > 0 && dupMap.get(element[0]) != null || undefined) {
            map.get(element[0]).forEach(val => {
                // dupMap=copyMap(map)
                if (!isFound) {
                    var array = JSON.parse(JSON.stringify(dupMap.get(element[0])));
                    array.splice(index, 1);
                    dupMap.set(element[0], array);
                    if (array.length == 0)
                        dupMap.delete(element[0]);
                    var [row, col] = val;
                    if (isValid(dupMap, element, 1, row, col)) {
                        result.push(element);
                        isFound = true;
                        return true;
                    }
                    array = dupMap.get(element[0]);
                    if (array && array.length > 0)
                        array = [...array.slice(0, index), val, ...array.slice(index)];
                    else
                        array = [val];
                    dupMap.set(element[0], array);
                }
                index++;
            });
        }
    });
    return result;
}
;
function isValid(mp, word, level, lastRow, lastCol, valid = false) {
    if (level >= word.length)
        return true;
    if (mp.get(word[level]) == null || undefined)
        return false;
    var index = 0;
    var dictionary = JSON.parse(JSON.stringify(mp.get(word[level])));
    var array;
    var len = dictionary.length;
    for (var i = 0; i < len; i++) {
        var row = dictionary[i][0];
        var col = dictionary[i][1];
        array = mp.get(word[level]);
        var cache = dictionary[i];
        if (isNeighbor(lastRow, lastCol, row, col)) {
            array.splice(index, 1);
            if (array.length == 0)
                mp.delete(word[level]);
            else
                mp.set(word[level], array);
            if (isValid(mp, word, level + 1, row, col)) {
                valid = true;
                return true;
            }
            array = mp.get(word[level]);
            if (array && array.length > 0)
                array = [...array.slice(0, index), cache, ...array.slice(index)];
            else
                array = [cache];
            mp.set(word[level], array);
        }
        // array=[...array.slice(0,index),cache,...array.slice(index)]
        // mp.set(word[level],array)
        index++;
    }
    return valid;
}
function isNeighbor(lastRow, lastCol, row, col) {
    if (lastRow + 1 == row && lastCol == col)
        return true;
    if (lastRow - 1 == row && lastCol == col)
        return true;
    if (lastCol + 1 == col && lastRow == row)
        return true;
    if (lastCol - 1 == col && lastRow == row)
        return true;
    return false;
}
function copyMap(map) {
    var newMap = new Map();
    map.forEach((value, key) => {
        newMap.set(key, JSON.parse(JSON.stringify(value)));
    });
    return newMap;
}
var board = [["a", "b"], ["a", "a"]];
var words = ["aba", "baa", "bab", "aaab", "aaa", "aaaa", "aaba"];
console.log(findWords(board, words));
// ["aba","aaa","aaab","baa","aaba"]
// [ 'aba', 'baa', 'aaab', 'aaa', 'aaba' ]
//# sourceMappingURL=wordSearchII.js.map