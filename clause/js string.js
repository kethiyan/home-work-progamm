function formatUserProfile(user) {
    const fullName = `${user.firstName} ${user.lastName}`.toUpperCase();
    
    const emailDomain = user.email.split('@')[1];

    return `User: ${fullName} | Domain: ${emailDomain}`;
}

const userObj = {
    firstName: "John",
    lastName: "Doe",
    email: "john.doe@example.com"
};

console.log(formatUserProfile(userObj)); 