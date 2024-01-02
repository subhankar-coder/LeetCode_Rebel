function minMutation(startGene, endGene, bank) {
    var tempString;
    var count = 0;
    if (bank.indexOf(endGene) == -1)
        return -1;
    let queue = [];
    for (var i = 0; i < endGene.length; i++) {
        if (endGene.charAt(i) != startGene.charAt(i)) {
            tempString = startGene;
            tempString = tempString.substring(0, i) + endGene.charAt(i) + tempString.substring(i + 1);
            if (bank.indexOf(tempString) != -1) {
                startGene = tempString;
                count++;
            }
            else {
                queue.push(i);
            }
        }
    }
    var set = new Set();
    var size = queue.length;
    var startingGene = startGene;
    var dupQueue = queue.slice().reverse();
    var base = ['A', 'C', 'T', 'G'];
    while (queue.length > 0) {
        if (startGene == endGene)
            break;
        // if(queue.length>1 && dupQueue==queue.slice(0,dupQueue.length+1))
        //     break
        var index = queue[0];
        queue.splice(0, 1);
        tempString = startGene;
        tempString = tempString.substring(0, index) + endGene.charAt(index) + tempString.substring(index + 1);
        if (!set.has(tempString)) {
            if (bank.indexOf(tempString) != -1) {
                startGene = tempString;
                set.add(startGene);
                count++;
            }
            else {
                var setindex = -1;
                for (i = 0; i < endGene.length; i++) {
                    tempString = startGene;
                    setindex = -1;
                    var terminate = false;
                    if (i == index)
                        continue;
                    if (endGene.charAt(i) != startGene.charAt(i) && !set.has(startGene.substring(0, i) + endGene.charAt(i) + startGene.substring(i + 1)) && bank.indexOf(startGene.substring(0, i) + endGene.charAt(i) + startGene.substring(i + 1)) != -1) {
                        startGene = startGene.substring(0, i) + endGene.charAt(i) + startGene.substring(i + 1);
                        count++;
                        set.add(startGene);
                        queue.splice(queue.indexOf(i), 1);
                        terminate = true;
                        break;
                    }
                    base.forEach(value => {
                        // set.add(tempString.substring(0,i)+value+tempString.substring(i+1));
                        if (!set.has(tempString.substring(0, i) + value + tempString.substring(i + 1)) && !terminate && tempString.charAt(i) != value && bank.indexOf(tempString.substring(0, i) + value + tempString.substring(i + 1)) != -1) {
                            startGene = tempString.substring(0, i) + value + tempString.substring(i + 1);
                            terminate = true;
                            setindex = i;
                            set.add(startGene);
                            count++;
                            return;
                        }
                    });
                    if (terminate)
                        break;
                }
                set.add(startGene);
                queue.push(index);
                if (setindex != -1)
                    queue.push(setindex);
            }
        }
        size--;
    }
    return startGene == endGene ? count : -1;
}
let startGene = "AAAAACCC";
let endGene = "AACCCCCC";
let bank = ["AAAACCCC", "AAACCCCC", "AACCCCCC"];
console.log(minMutation(startGene, endGene, bank));
//"AACCTTGG"
//"AATTCCGG"
//["AATTCCGG","AACCTGGG","AACCCCGG","AACCTACC"]
//# sourceMappingURL=MinGeneticMutation.js.map