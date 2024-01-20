function findWords(board: string[][], words: string[]): string[] {
    var map:Map<string,number[][]>=new Map();
    var boardRow : number=board.length
    var boardCol: number=board[0].length
    var result=[]

    for(var i=0;i<boardRow;i++){
        for(var j=0;j<boardCol;j++){

            var key:string=board[i][j]
            if(map.get(key)!=null || undefined){
                var array:number[][]=map.get(key)
                array.push([i,j])
                map.set(key,array)
            }else{
                var array:number[][]=[]
                array.push([i,j])
                map.set(key,array)
            }
        }
    }
    var isFound:boolean
    words.forEach(element=>{
        isFound=false
        var dupMap=copyMap(map)
        if(isValid(dupMap,element,0,0,0)) {
            result.push(element)
        }       
    })
    return result
};

function isValid(mp:Map<string,number[][]>,word:string,level:number,lastRow:number,lastCol:number,valid:boolean=false):boolean{
    if(level>=word.length)
        return true
    if(mp.get(word[level])==null||undefined)
        return false

    var index=0
    var dictionary=JSON.parse(JSON.stringify(mp.get(word[level])))
    var array:number[][]
    var len=dictionary.length
    for(var i=0;i<len;i++){

        var row=dictionary[i][0]
        var col=dictionary[i][1]
        array=mp.get(word[level])
        var cache=dictionary[i]
        if(level==0 || isNeighbor(lastRow,lastCol,row,col)){
            array.splice(index,1)
            if(array.length==0)
                mp.delete(word[level])
            else
                mp.set(word[level],array)
            if(isValid(mp,word,level+1,row,col)){
                valid=true
                return true
            }
            array=mp.get(word[level])
            if(array && array.length>0)
                array=[...array.slice(0,index),cache,...array.slice(index)]
            else
                array=[cache]
            mp.set(word[level],array)
        }
        // array=[...array.slice(0,index),cache,...array.slice(index)]
        // mp.set(word[level],array)
        index++
    }
    return valid
}
function isNeighbor(lastRow:number,lastCol:number,row:number,col:number){
    if(lastRow+1==row && lastCol==col)
        return true
    if(lastRow-1==row && lastCol==col)
        return true
    if(lastCol+1==col && lastRow==row)
        return true
    if(lastCol-1==col && lastRow==row)
        return true
    return false
}

function copyMap(map:Map<string,number[][]>):Map<string,number[][]>{

    var newMap:Map<string,number[][]>=new Map()
    map.forEach((value,key)=>{
        newMap.set(key,JSON.parse(JSON.stringify(value)))
    })
    return newMap;
}

var board:string[][]=[["a","b"],["a","a"]]
var words:string[]=["aba","baa","bab","aaab","aaa","aaaa","aaba"]
console.log(findWords(board,words));

// ["aba","aaa","aaab","baa","aaba"]
// [ 'aba', 'baa', 'aaab', 'aaa', 'aaba' ]