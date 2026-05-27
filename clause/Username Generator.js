function generateUsername(name, phoneNumber) {
    const namePart = name.slice(0, 3);
    
    const phoneStr = phoneNumber.toString();
    const phonePart = phoneStr.slice(-2);
    
    return (namePart + phonePart).toLowerCase();
}

console.log(generateUsername("Alex", "9876543210")); 
console.log(generateUsername("Bo", 5551234));        