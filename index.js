function processData(input) {
    //Enter your code here
    let string = input[0];
    let number = input[1];
    let dict = input[2];
    for(let i in dict) {
        if(string.includes(dict[i])) {
            console.log(true);
        }else {
            console.log(false);
            break;
        }
    }
}

processData(["applepenappl",2, ["apple","pen"]]);