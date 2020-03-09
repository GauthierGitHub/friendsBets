
export class User {
    
    private _id: number;
    private _nickname: string;
    private _email: string;    
    private _password: string;
    private _token: string;
    private _friends: User[];

    constructor();
    constructor(id: number, nickname: string, email: string, password: string);
    constructor(id?: number, nickname?: string, email?: string, password?: string) {
        this._id = id ? id : 0;
        this._nickname = nickname ? nickname : "";
        this._email = email ? email : "";
        this._password = password ? password : "";
    }

    get id(): number {
        return this._id;
    }

    set id(id: number) {
        this._id = id;
    }

    get nickname(): string {
        return this._nickname;
    }

    set nickname(nickname: string) {
        this._nickname = nickname;
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

    get friends(): User[] {
        return this._friends;
    }

    set friends(_friends: User[]) {
        this._friends = _friends;
    }
}