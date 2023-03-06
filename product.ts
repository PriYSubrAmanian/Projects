export class Product {
    constructor(public productid:number,
        public productname:string,
        public created_user:string,
        public created_date_time:Date,
        public last_modified_user:string,
        public last_modified_date_time:Date,
        public productbuying_price:number,
        public productselling_price:number)
    {

    }
}
