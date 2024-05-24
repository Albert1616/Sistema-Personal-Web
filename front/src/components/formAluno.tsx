import { Button } from "./ui/button";
import { Input } from "./ui/input";
import { Label } from "./ui/label";

export default function FormAluno() {
  return (
    <form action="">
        <div>
            <Label htmlFor="nome">Nome</Label>
            <Input type="text"/>
            <Label htmlFor="nome">Email</Label>
            <Input type="text"/>
            <Label htmlFor="nome">Data de nascimento</Label>
            <Input type="date"/>
            <Button>Adicionar</Button>
        </div>
    </form>
  );
}
