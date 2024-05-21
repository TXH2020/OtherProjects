function vowelcount(word){
    var vowelc={}
    for(var i=0;i<word.length;i++)
    {
        var c=word[i].toLowerCase()
        if(c==='a'||c==='e'||c==='i'||c==='o'||c==='u')
        if(vowelc[c]!=null)
        vowelc[c]++;
        else
        vowelc[c]=1;}
    return vowelc;
}
console.log(vowelcount('HelloMOoto'))