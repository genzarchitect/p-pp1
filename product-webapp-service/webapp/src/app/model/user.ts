enum Type{
    Owner,
    Player
}


export class User{
   
        public userEmail?:string;
        public userPassword?:string;
        public userType?:Type;
        public userGender?:string;
        public userMobile?:string;
        public userAddress?:string;
    
}