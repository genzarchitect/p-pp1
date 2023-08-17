enum Type{
    Owner,
    Player
}


export class User{
    constructor(
        public userEmail?:string,
        public userPassword?:string,
        public userType?:Type
    ){}
}