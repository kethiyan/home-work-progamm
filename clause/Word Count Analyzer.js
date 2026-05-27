function analyzeSentence(sentence) {
    const trimmedStr = sentence.trim(); 
    
    const wordsArray = trimmedStr ? trimmedStr.split(/\s+/) : [];

    return {
        totalCharacters: sentence.length,
        totalWords: wordsArray.length,
        lowercaseSentence: sentence.toLowerCase()
    };
}

console.log(analyzeSentence("JavaScript is amazing!"));
