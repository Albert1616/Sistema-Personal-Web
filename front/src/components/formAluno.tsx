import { Button } from "./ui/button";
import { Input } from "./ui/input";
import { Label } from "./ui/label";

export default function FormAluno() {
  return (
    <form action="" className="h-full w-[25%]">
        <div className="flex flex-col justify-between gap-5">
          <div className="gap-1">
            <Label htmlFor="nome">Nome</Label>
            <Input type="text"/>
          </div>
          <div className="gap-1">
            <Label htmlFor="nome">Email</Label>
            <Input type="text"/>
          </div>
          <div className="gap-1">
            <Label htmlFor="nome">Data de nascimento</Label>
            <Input type="date"/>
          </div>
          <Button className="mt-4">Adicionar</Button>
        </div>
    </form>
  );
}
