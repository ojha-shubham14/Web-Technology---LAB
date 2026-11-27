function calculate(operation){
    const num1 = parseFloat(document.getElementById("num1").value);
    const num2 = parseFloat(document.getElementById("num2").value);
    let result;

    const needTwo =(operation!=='square' && operation!=='square-root');

    if(isNaN(num1)||(needTwo && isNaN(num2))){
        document.getElementById('result').textContent="Invalid Input";
        return;
    }

    switch(operation){
        case "sum":
            result = num1+num2;
            break;
        case "difference":
            result = num1-num2;
            break;
        case "multiplication":
            result = num1*num2;
            break;
        case "division":
            result = num2 !== 0 ? num1/num2: "Invalid divid by zero";
            break;
        case "modulus":
            result = num2!==0 ? num%num2 :"Divide by zero error";
            break;
        case "square-root":
            result = Math.sqrt(num1);
            break;
        case "square":
            result = Math.pow(num1,2);
            break;
        default:
            result = "Invalid Operation";
    }

    document.getElementById("result").textContent=result;
}
