
export class User {
    
    private _id: number;
    private _alias: string;
    private _email: string;    
    private _password: string;
    private _token: string;


    constructor();
    constructor(id: number, alias: string, email: string, password: string);
    constructor(id?: number, alias?: string, email?: string, password?: string) {
        this._id = id ? id : 0;
        this._alias = alias ? alias : "";
        this._email = email ? email : "";
        this._password = password ? password : "";
    }

    get id(): number {
        return this._id;
    }

    set id(id: number) {
        this._id = id;
    }

    get alias(): string {
        return this._alias;
    }

    set alias(alias: string) {
        this._alias = alias;
    }

    get email(): string {
        return this._email;
    }

    set email(email: string) {
        this._email = email;
    }

    get password(): string {
        return this._password;
    }

    set password(password: string) {
        this._password = password;
    }

    get token(): string {
        return this._token;
    }

    set token(token: string) {
        this._token = token;
    }
}