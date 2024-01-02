interface IElements{
    val:number,
    dist:number
}

function snakeandladders(boards:number[][]):number {
    let len:number = boards.length
    let graph: number [] = new Array(len*len)
    let j,count:number = 0
    let isFwd:boolean=true
    let dest:number = len*len-1
    
    for(var i=len-1;i>=0;i--){
        if(isFwd)
            j=0
        else
            j=len-1
        while(j>=0 && j<len){
            if(boards[i][j]!=-1)
                graph[count++]=boards[i][j]-1
            else
                graph[count++]=boards[i][j]

            if(isFwd)
                j++
            else
                j--
        }
        isFwd=!isFwd
    }

    if(graph[dest]!=-1)
        return -1
    var element : IElements={
        val:0,
        dist:1
    }
    var queue:IElements[]= [element]
    var visited :number[]= []
    while(queue.length>0){
        
        var val=queue[0].val
        var dist = queue[0].dist
        queue.splice(0,1)
        var start=val+1
        var end=val+6

        if(start<=dest && end>=dest){
            break
        }

        if(visited.indexOf(val)==-1){
            visited.push(val)
            while (start<=end) {
                if(graph[start]==-1){
                    val=start
                }else{
                    val=graph[start]
                    if(val==dest)
                        return dist
                }
                var queueEle:IElements={
                    val:val,
                    dist:dist+1
                }
                queue.push(queueEle)
                start++
            }
        }
    }
    return start<=dest && end>=dest?dist:-1
}
// let boards: number[][] = [[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,35,-1,-1,13,-1],[-1,-1,-1,-1,-1,-1],[-1,15,-1,-1,-1,-1]]
let boards:number[][]=[[1,1,-1],[1,1,1],[-1,1,1]]
console.log(snakeandladders(boards))
